package ch.zhaw.deeplearningjava.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ai.djl.Application;
import ai.djl.Device;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;

public class SentimentAnalysis {
    Predictor<String, Classifications> predictor;
    private static final Logger LOG = LoggerFactory.getLogger(SentimentAnalysis.class);

    SentimentAnalysis() {
        try {
            Criteria<String, Classifications> criteria = Criteria.builder()
                    .optApplication(Application.NLP.SENTIMENT_ANALYSIS)
                    .setTypes(String.class, Classifications.class).optDevice(Device.cpu())
                    .optProgress(new ProgressBar()).build();

            ZooModel<String, Classifications> model = criteria.loadModel();
            predictor = model.newPredictor();

        } catch (Exception e) {
            LOG.error("Predicted error: ", e);
        }
    }

    public Classifications predict(String input) throws TranslateException {
        LOG.info("Input: ", input);
        return predictor.predict(input);
    }
}
package ch.zhaw.deeplearningjava.playground;

import org.springframework.web.bind.annotation.RestController;

import ai.djl.modality.Classifications;
import ai.djl.translate.TranslateException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SentimentController {

    private SentimentAnalysis analysis = new SentimentAnalysis();

    @GetMapping("/ping")
    public String ping() {
        return "hello world!";
    }

    @GetMapping("/sentiment")
    public String predict(@RequestParam(name = "text", required = true) String param)
            throws TranslateException {
        var result = analysis.predict(param);
        return result.toString();
    }
}
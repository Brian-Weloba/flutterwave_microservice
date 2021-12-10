package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.FlutterwaveServiceProxy;
import com.mctv.flutterwave.models.Payload;
import com.mctv.flutterwave.repositories.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.mctv.flutterwave.utils.URLs.MICROSERVICE_URL;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * Controller for the ModelAndViewController
 */
@Controller
@EnableFeignClients(basePackageClasses = FlutterwaveServiceProxy.class)
public class ModelAndViewController {
    private final FlutterwaveController controller;
    private final PayloadRepository repo;

    /**
     * @param repo          Injected repository
     *                      <p>
     * @param controller    Inject the flutterwave controller
     */
    @Autowired
    public ModelAndViewController(PayloadRepository repo, FlutterwaveController controller) {
        this.repo = repo;
        this.controller = controller;
    }

    /**
     * @param status  The status of the payment
     * @param message The message of the payment
     * @param tx_ref  The transaction reference of the payment
     * @param model   Spring framework model
     * @return The model and view for the payment error page
     * <p>
     * This method is used to display the payment error page
     */
    @GetMapping(value = "/error",
            produces = {"text/html",
                    "application/json"}
    )
    public String error(@RequestParam String status, @RequestParam String message, @RequestParam(required = false) String tx_ref, Model model) {
        model.addAttribute("tx_ref", tx_ref);
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        model.addAttribute("url", MICROSERVICE_URL);
        return "error";
    }

    /**
     * @param ref The reference of the payment
     * @return The model and view for the rave model to retry payment
     * <p>
     * This method is used to retry a payment
     */
    @GetMapping("/retry-payment")
    public ModelAndView retryPayment(@RequestParam String ref) {
        Payload payload = repo.findByRef(ref);
        return controller.makePayment(payload);
    }
}

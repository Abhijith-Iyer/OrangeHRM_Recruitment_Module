package utilities;

import java.util.ArrayList;
import java.util.List;

//import io.cucumber.core.plugin.Options.Plugin;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.TestStepStarted;

public class StepCaptureListener implements EventListener, Plugin {
	 private final static List<String> stepNames = new ArrayList<>();

	    @Override
	    public void setEventPublisher(EventPublisher publisher) {
	        publisher.registerHandlerFor(TestStepStarted.class, this::handleStepStarted);
	        System.out.println("StepCaptureListener initialized");

	    }

	    private void handleStepStarted(TestStepStarted event) {
	        TestStep step = event.getTestStep();

	        if (step instanceof PickleStepTestStep) {
	            String stepText = ((PickleStepTestStep) step).getStep().getText();
	            stepNames.add(stepText);
	            System.out.println("Step started: " + stepText);
	            System.out.println("Step started event received");// Optional logging
	        }
	    }

	    public static List<String> getStepNames() {
	        return stepNames;
	    }
	    public static void reset() {
	        stepNames.clear();
	    }


}

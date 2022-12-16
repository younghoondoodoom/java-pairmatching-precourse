package pairmatching.domain.config;

import java.io.IOException;
import pairmatching.common.input.InputContext;
import pairmatching.common.option.OptionContext;
import pairmatching.domain.pair.controller.PairController;
import pairmatching.domain.pair.repository.PairRepository;
import pairmatching.domain.pair.repository.PairRepositoryImpl;
import pairmatching.domain.pair.service.PairService;
import pairmatching.domain.pair.service.PairServiceImpl;
import pairmatching.domain.pair.validation.InputValidationChain;
import pairmatching.domain.pair.validation.validator.InputValidateSuccessChain;
import pairmatching.domain.pair.validation.validator.MainOptionValidateChain;
import pairmatching.domain.pair.validation.validator.NullOrBlankValidateChain;
import pairmatching.domain.pair.validation.validator.PairInformationValidateChain;
import pairmatching.domain.pair.validation.validator.RematchValidateChain;

public class PairConfig {

    public static PairController config() throws IOException {
        return new PairController(pairServiceDI(), makeValidationChain(), new InputContext(), new OptionContext());
    }

    private static PairService pairServiceDI() {
        return new PairServiceImpl(PairRepositoryImpl.getInstance());
    }

    private static InputValidationChain makeValidationChain() {
        InputValidationChain nullOrBlankValidateChain = new NullOrBlankValidateChain();
        InputValidationChain mainOptionValidateChain = new MainOptionValidateChain();
        InputValidationChain pairInformationValidateChain = new PairInformationValidateChain();
        InputValidationChain rematchValidateChain = new RematchValidateChain();
        nullOrBlankValidateChain.setNext(mainOptionValidateChain);
        mainOptionValidateChain.setNext(pairInformationValidateChain);
        pairInformationValidateChain.setNext(rematchValidateChain);
        rematchValidateChain.setNext(new InputValidateSuccessChain());
        return nullOrBlankValidateChain;
    }
}

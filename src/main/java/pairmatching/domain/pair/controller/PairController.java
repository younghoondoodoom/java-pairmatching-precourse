package pairmatching.domain.pair.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.common.input.InputContext;
import pairmatching.common.option.OptionContext;
import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;
import pairmatching.domain.pair.exception.PairAlreadyExistException;
import pairmatching.domain.pair.model.Crew;
import pairmatching.domain.pair.model.Pair;
import pairmatching.domain.pair.model.PairInformation;
import pairmatching.domain.pair.service.PairService;
import pairmatching.domain.pair.type.Course;
import pairmatching.domain.pair.type.Level;
import pairmatching.domain.pair.type.Mission;
import pairmatching.domain.pair.type.ValidationType;
import pairmatching.domain.pair.util.io.FileInput;
import pairmatching.domain.pair.validation.InputValidationChain;
import pairmatching.domain.pair.view.InputView;
import pairmatching.domain.pair.view.OutputView;

public class PairController {

    private final PairService pairService;
    private final InputValidationChain validator;
    private final InputContext inputContext;
    private final OptionContext optionContext;
    private final List<Crew> frontendCrews;
    private final List<Crew> backendCrews;

    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    public PairController(PairService pairService, InputValidationChain validator, InputContext inputContext,
        OptionContext optionContext) throws IOException {
        this.pairService = pairService;
        this.validator = validator;
        this.inputContext = inputContext;
        this.optionContext = optionContext;
        backendCrews = getCrews(BACKEND_CREW_FILE_PATH, Course.BACKEND);
        frontendCrews = getCrews(FRONTEND_CREW_FILE_PATH, Course.FRONTEND);
    }

    public void run() {
        while (true) {
            String mainOption = getMainOption();
            if (mainOption.equals("Q")) {
                break;
            }
            if (mainOption.equals("1")) {
                optionContext.workWithOptionStrategy(this::match);
            }
            if (mainOption.equals("2")) {
                optionContext.workWithOptionStrategy(this::getPairs);
            }
            if (mainOption.equals("3")) {
                pairService.init();
                System.out.println("초기화 되었습니다.");
            }
        }
    }

    private boolean getPairs() {
        List<Pair> pairs = pairService.findPairs(makePairInformation());
        OutputView.printPairResult(pairs);
        return true;
    }

    private PairInformation makePairInformation() {
        String[] input = getPairInformation().split(" ");
        Course course = Course.findByName(input[0].substring(0, input[0].length() - 1));
        Level level = Level.findByName(input[1].substring(0, input[1].length() - 1));
        Mission mission = Mission.findByName(input[2]);
        return new PairInformation(course, level, mission);
    }

    private boolean match() {
        List<Pair> result = getPairList();
        if (result != null) {
            OutputView.printPairResult(result);
            return true;
        }
        return false;
    }

    private List<Pair> getPairList() {
        String[] input = getPairInformation().split(" ");
        Course course = Course.findByName(input[0].substring(0, input[0].length() - 1));
        Level level = Level.findByName(input[1].substring(0, input[1].length() - 1));
        Mission mission = Mission.findByName(input[2]);
        PairInformation pairInformation = new PairInformation(course, level, mission);
        List<Crew> crews = getCrews(course);
        return tryMatch(pairInformation, crews);
    }

    private List<Pair> tryMatch(PairInformation pairInformation, List<Crew> crews) {
        List<Pair> result = null;
        try {
            result = pairService.match(crews, pairInformation);
        } catch (PairAlreadyExistException e) {
            if (getRematch().equals("네")) {
                result = pairService.reMatch(crews, pairInformation);
            }
        }
        return result;
    }

    private String getMainOption() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            String input = InputView.inputMainOption();
            List<ValidationType> validationTypes = List.of(ValidationType.NULL_OR_BLANK, ValidationType.MAIN_OPTION);
            return validateRequest(validator, new InputValidationRequest(validationTypes, input));
        });
    }

    private String getRematch() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            String input = InputView.inputRematch();
            List<ValidationType> validationTypes = List.of(ValidationType.NULL_OR_BLANK, ValidationType.REMATCH);
            return validateRequest(validator, new InputValidationRequest(validationTypes, input));
        });
    }

    private String getPairInformation() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            String input = InputView.inputPairInformation();
            List<ValidationType> validationTypes = List.of(ValidationType.NULL_OR_BLANK, ValidationType.PAIR_INFORMATION);
            return validateRequest(validator, new InputValidationRequest(validationTypes, input));
        });
    }

    private List<Crew> getCrews(Course course) {
        if (course.equals(Course.BACKEND)) {
            return backendCrews;
        }
        return frontendCrews;
    }

    private static List<Crew> getCrews(String path, Course course) throws IOException {
        List<String> input = FileInput.readFile(path);
        List<Crew> crews = new ArrayList<>();
        for (String data : input) {
            crews.add(new Crew(course, data));
        }
        return crews;
    }


    private String validateRequest(InputValidationChain validator, InputValidationRequest request) {
        InputValidationResponse response = validator.validate(request);
        if (!response.isValid()) {
            throw new IllegalArgumentException(response.getErrorMessage());
        }
        return request.getTarget();
    }
}

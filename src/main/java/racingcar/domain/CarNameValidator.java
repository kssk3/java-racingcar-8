package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    public void validate(List<String> names) {
        validateNotEmpty(names);
        validateDuplicates(names);
        validateEachNames(names);
    }

    private void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상 이름이 필요합니다.");
        }
    }

    private void validateDuplicates(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 이름이 존재합니다: " + name);
            }
        }
    }

    private void validateEachNames(List<String> names) {
        names.forEach(CarName::new);
    }

}

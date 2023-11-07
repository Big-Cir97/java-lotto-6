package lotto.model;

import static lotto.util.Constants.CONFIG_NUMBERS_SIZE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.ErrorType;

public class Lotto {

    private List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
            .map(Number::getNumber)
            .collect(Collectors.toList());
    }

    private List<Number> toNumber(List<Integer> numbers) {
        return numbers.stream()
            .map(Number::new)
            .sorted()
            .toList();
    }

    private void validate(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != CONFIG_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != CONFIG_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorType.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}

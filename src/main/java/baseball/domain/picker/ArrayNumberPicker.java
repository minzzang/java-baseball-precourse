package baseball.domain.picker;

public class ArrayNumberPicker implements NumberPicker {

    private int index;
    private int[] arr;

    public ArrayNumberPicker(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int peek() {
        try {
            return arr[index++];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalStateException("더 이상 뽑을 숫자가 없습니다.");
        }
    }
}

package 二分法.modle;

public class GuessGame {
    int num;

    /**
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    protected int guess(int num) {
        return num < this.num ? -1 : num == this.num ? 0 : 1;
    }
}

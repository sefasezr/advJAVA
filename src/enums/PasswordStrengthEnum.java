package enums;

public enum PasswordStrengthEnum {
    LOW(10),
    MEDIUM(50),
    HIGH(100);

    private final int level;//field

    //param const

    PasswordStrengthEnum(int level) {
        this.level = level;
    }

    //getter yaptık setter yapamayız çünkü enum typelar sabit
    public int getLevel() {
        return level;
    }
}

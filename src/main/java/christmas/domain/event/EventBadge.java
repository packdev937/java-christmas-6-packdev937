package christmas.domain.event;

public enum EventBadge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final int criterionValue;
    private final String badgeName;

    EventBadge(String badgeName, int criterionValue) {
        this.badgeName = badgeName;
        this.criterionValue = criterionValue;
    }

    public int getCriterionValue() {
        return criterionValue;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static EventBadge getBadgeByAmount(double benefitAmount) {
        if (benefitAmount >= SANTA.getCriterionValue()) {
            return SANTA;
        } else if (benefitAmount >= TREE.getCriterionValue()) {
            return TREE;
        } else if (benefitAmount >= STAR.getCriterionValue()) {
            return STAR;
        } else {
            return NONE;
        }
    }
}

package demo.Entity;

public enum Color {

    WHITE("WHITE"),
    BLACK("BLACK"),
    GREEN("GREEN"),
    RED("RED"),
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    BROWN("BROWN");

    private String color;

    private Color(String color) {
        this.color = color;
    }

    public static Color findByColorValue(final String abbr){
        for(Color color : values()){
            if(color.getColor().equals(abbr)){
                return color;
            }
        }
        throw new IllegalArgumentException("Such value was not found " +
                "in enum");
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }

}

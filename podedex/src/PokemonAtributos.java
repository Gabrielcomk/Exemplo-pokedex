

@JsonIngnorePreperties(ignoreUnknom = true)
 class PokemonAtributos {
    private String name;
    private String generation;
    private String type;
    private int number;
    private int life;

    @Override
    public String toString() {
        return "PokemonAtributos{" +
                "name='" + name + '\'' +
                ", generation='" + generation + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", life=" + life +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getGeneration() {
        return generation;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getLife() {
        return life;
    }

    public PokemonAtributos(String name, String generation, String type, int number, int life) {
        this.name = name;
        this.generation = generation;
        this.type = type;
        this.number = number;
        this.life = life;
    }
}

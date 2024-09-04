class Player{
    private String name;
    private int position;
    private boolean chance;

    Player(String name, int position, boolean chance){
        this.name = name;
        this.position = position;
        this.chance = chance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isChance() {
        return this.chance;
    }

    public boolean getChance() {
        return this.chance;
    }

    public void setChance(boolean chance) {
        this.chance = chance;
    }

}
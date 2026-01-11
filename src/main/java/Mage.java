public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) throws InsufficientManaException, InvalidTargetException, CharacterAlreadyDeadException {
        if (target == null) {
            throw new InvalidTargetException();
        }
        if (!target.isAlive()) {
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }
        if (this.mana - 10 >= 0) {
            this.mana -= 10;
            target.receiveDamage(20);
            target.status = Status.POISONED;
        } else {
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }
    }

    public void heal(Character target) throws InsufficientManaException, InvalidTargetException, CharacterAlreadyDeadException {
        if (target == null) {
            throw new InvalidTargetException();
        }
        if (!target.isAlive()) {
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }
        if (this.mana - 15 >= 0) {
            this.mana -= 15;
            target.health += 20;
        } else {
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }
    }

}

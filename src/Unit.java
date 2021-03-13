import java.util.ArrayList;
import java.util.List;

public abstract class Unit {

    private int hp;
    private int dmg;

    private boolean isAlive = true;
    List<OnValueChange<Integer>> onHpChangeListeners = new ArrayList<>();

    public Unit(int hp, int dmg) {
        this.hp = hp;
        this.dmg = dmg;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        if (hp != this.hp){
            this.hp = hp;
            onHpChangeListeners.forEach(i->{i.onChange(this.hp);});
        }
        if (hp < 0){
            this.hp = 0;
            isAlive = false;
            onHpChangeListeners.forEach(i->{i.onChange(this.hp);});
        }
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void attack(Unit target){
        target.setHp(target.getHp() - getDmg());
    }

    public boolean isAlive() {
        return isAlive;
    }


}

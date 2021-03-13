public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Hunter hunter = new Hunter();

        warrior.onHpChangeListeners.add(newHp -> {
            System.out.println("Warrior has hp: " + newHp);
        });
        hunter.onHpChangeListeners.add(newHp ->{
            System.out.println("Hunter has hp: " + newHp);
        });

        Thread thread1 = new Thread(() -> {
            while (hunter.isAlive()){
            warrior.attack(hunter);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (warrior.isAlive()) {
                hunter.attack(warrior);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    //Список слушателей на изменение урона. Сделать способности.
}

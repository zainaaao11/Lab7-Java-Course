package problem3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Player player = new Player("Tim", 10, 15);
        Monster monster = new Monster("Werewolf", 20, 40);
        System.out.println("=== toString() ===");
        System.out.println(player);
        System.out.println(monster);
        System.out.println("\n=== write() ===");
        System.out.println("Player: " + player.write());
        System.out.println("Monster: " + monster.write());
        System.out.println("\n=== read() ===");
        List<String> playerList = new ArrayList<>(Arrays.asList("Initial"));
        List<String> monsterList = new ArrayList<>(Arrays.asList("Initial"));
        player.read(playerList);
        monster.read(monsterList);
        System.out.println("Player: " + playerList);
        System.out.println("Monster: " + monsterList);
        System.out.println("\n=== Empty list ===");
        List<String> empty = new ArrayList<>();
        player.read(empty);
        System.out.println(empty);
        System.out.println("\n=== Null list ===");
        player.read(null);
        System.out.println("No exception thrown");
        System.out.println("\n=== Player setters ===");
        player.setWeapon("Axe");
        player.setHitPoints(50);
        System.out.println(player);
    }
}

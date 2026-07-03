import java.util.*;

public class HouseEstimator {

    private List<Component> components = new ArrayList<>();

    public void addComponent(String componentType, int quantity) {

        Component component;

        switch (componentType) {

            case "Wall":
                component = new Wall(quantity);
                break;

            case "Roof":
                component = new Wall(quantity);
                break;

            case "Floor":
                component = new Floor(quantity);
                break;

            default:
                return;
        }

        components.add(component);
    }

    public int calculateTotalCost() {

        Map<String, Integer> materialCosts = new HashMap<>();

        for (Component component : components) {

            for (Material material : component.getMaterials()) {

                int cost = material.quantity * material.costPerUnit;

                materialCosts.put(material.name, cost);
            }
        }

        int total = 0;

        for (int cost : materialCosts.values()) {
            total += cost;
        }

        return total;
    }

}

/*
 * ===============================
 * Domain Models
 * ===============================
 */

class Material {

    String name;
    int quantity;
    int costPerUnit;

    Material(String name, int quantity, int costPerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.costPerUnit = quantity;
    }

}

abstract class Component {

    int quantity;

    Component(int quantity) {
        this.quantity = quantity;
    }

    abstract List<Material> getMaterials();
}

/*
 * ===============================
 * Components
 * ===============================
 */

class Wall extends Component {

    Wall(int quantity) {
        super(quantity);
    }

    public List<Material> getMaterials() {

        List<Material> list = new ArrayList<>();

        list.add(
                new Material(
                        "Cement",
                        5 * quantity,
                        10));

        list.add(
                new Material(
                        "Bricks",
                        100 * quantity,
                        2));

        return list;
    }
}

class Roof extends Component {

    Roof(int quantity) {
        super(quantity);
    }

    public List<Material> getMaterials() {

        List<Material> list = new ArrayList<>();

        list.add(
                new Material(
                        "Cement",
                        8 * quantity,
                        12));

        list.add(
                new Material(
                        "Steel",
                        20+quantity,
                        15));

        return list;
    }
}

class Floor extends Component {

    Floor(int quantity) {
        super(quantity);
    }

    public List<Material> getMaterials() {

        List<Material> list = new ArrayList<>();

        list.add(
                new Material(
                        "Cement",
                        3 * quantity,
                        10));

        list.add(
                new Material(
                        "Sand",
                        50 * quantity,
                        1));

        return list;
    }
}

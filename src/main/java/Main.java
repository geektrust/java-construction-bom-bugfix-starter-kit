public class Main {

    private static HouseEstimator estimator = new HouseEstimator();

    public static void main(String[] args) {
        for (String arg : args) {
            handle(arg);
        }
    }

    private static void handle(String input) {

        String[] tokens = input.trim().split(" ");

        String command = tokens[0];

        switch (command) {

            case "ADD_COMPONENT":

                String component = tokens[1];
                int quantity = Integer.parseInt(tokens[2]);

                estimator.addComponent(component, quantity);
                break;

            case "TOTAL_COST":
                System.out.println(
                    "Total Construction Cost: " +
                    estimator.calculateTotalCost()
                );
                break;

            default:
                System.out.println("INVALID_COMMAND");
        }
    }
}
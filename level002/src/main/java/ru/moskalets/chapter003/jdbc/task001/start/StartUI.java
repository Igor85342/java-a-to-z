package ru.moskalets.chapter003.jdbc.task001.start;
/**
 * The class displays the menu items.
 * author Igor Moskalets
 */
public class StartUI {
    /**
     * ranges.
     */
    private int[] ranges = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    /**
     * input.
     */
    private Input input;

    /**
     * StartUI.
     * @param input .
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * init().
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        UserAction deleteAction = new UserAction() {
            public int key() {
                return 9;
            }
            public void execute(Input input, Tracker tracker) {
                //todo
            }
            public String info() {
                return "9. Delete";
            }
        };
        menu.addAction(deleteAction);
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y)")));
    }

    /**
     * main.
     * @param args .
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
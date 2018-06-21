package ru.moskalets.chapter003.jdbc.task001.start;

import java.sql.SQLException;

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
    public void init() throws SQLException {
        //Tracker tracker = new Tracker();
        try (Tracker tracker = new Tracker("jdbc:postgresql://localhost:5432/tracker", "postgres", "password")) {
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
    }

    /**
     * main.
     * @param args .
     */
    public static void main(String[] args) throws SQLException {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
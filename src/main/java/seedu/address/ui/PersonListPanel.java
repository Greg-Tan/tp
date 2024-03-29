package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList, ObservableList<Integer> indexList) {
        super(FXML);
        logger.info("this is the original index list: "+ indexList.toString());
        logger.info("this is the current person list: "+ personList.toString());
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell(indexList));
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        private ObservableList<Integer> indexList;

        PersonListViewCell(ObservableList<Integer> indexList) {
            this.indexList = indexList; // Initialize the indexList field
        }
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                int displayIndex = indexList.get(getIndex()) + 1;
                logger.info("this is the person's index " + displayIndex);
                setGraphic(new PersonCard(person, displayIndex).getRoot());
            }
        }
    }

}

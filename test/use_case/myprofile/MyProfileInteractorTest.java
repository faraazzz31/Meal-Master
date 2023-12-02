package use_case.myprofile;

import data_access.InMemoryUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyProfileInteractorTest {
    @Test
    void successTest() {
        MyProfileInputData inputData = new MyProfileInputData("faraaz");
        MyProfileDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        UserFactory factory = new CommonUserFactory();
        PlannerFactory plannerFactory = new PlannerFactory();
        User user = factory.create("faraaz", "Passw", "Faraaz", 19, "Man", 170, 60, plannerFactory.create("faraaz"));
        ((InMemoryUserDataAccessObject) userRepository).save(user);

        MyProfileOutputBoundary successPresenter = new MyProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(MyProfileOutputData output) {
                assertEquals("faraaz", output.getUsername());
                assertEquals("Faraaz", output.getName());
                assertEquals(19, output.getAge());
                assertEquals("Man", output.getGender());
                assertEquals(170, output.getHeight());
                assertEquals(60, output.getWeight());
                assertEquals(user, output.getUser());
            }
        };

        MyProfileInputBoundary interactor = new MyProfileInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}

package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class LaunchOrderListingTest {
    // check to see if they are unique that once we have the launch list,
    // e are having the same number, having something with size and checkin the int

//    @BeforeEach


    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    void LaunchesAre_NumberedAsReceived_DestinationsAreUnique() {
        // Arrange
        ISpacelineLaunchInfoProvider mock = new UnorderedLaunchesStub();

        // Act
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        List<LaunchInfo> launchList = sut.getLaunchList();

        //Assert
        int listSize = launchList.size();
        Assertions.assertEquals(2, listSize);
    }

    @Test
    void Launches_Are_Sorted_Correctly_When_Destinations_Are_Unique() {
        //Arrange
        ISpacelineLaunchInfoProvider mock = new UnorderedLaunchesStub();

        //Act
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        List<LaunchInfo> launchList = sut.getLaunchList();

        //Assert
        String destination1 = launchList.get(0).getDestination();
        String destination2 = launchList.get(1).getDestination();
//        Assertions.assertTrue(destination1.compareTo(destination2) > 0, "Expect dest1 to be listed first");

        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals("A", destination1);
                    Assertions.assertEquals("B", destination2);
                }
        );
    }

    private static class UnorderedLaunchesStub implements ISpacelineLaunchInfoProvider {

        @Override
        public List<LaunchInfo> getCurrentLaunches() {
            List<LaunchInfo> launches = new ArrayList<>();
            launches.add(CreateLaunchInfo("B"));
            launches.add(CreateLaunchInfo("A"));
            return launches;
        }

        private LaunchInfo CreateLaunchInfo(String B) {
            var launchInfo1 = new LaunchInfo(UUID.randomUUID());
            launchInfo1.setDestination(B);
            return launchInfo1;
        }
    }
}

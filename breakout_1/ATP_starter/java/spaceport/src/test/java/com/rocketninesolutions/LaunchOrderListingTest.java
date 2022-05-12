package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LaunchOrderListingTest {
    // check to see if they are unique that once we have the launch list, we are having the same number, having something with size and checkin the int

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    public void LaunchesAre_NumberedAsReceived_DestinationsAreUnique() {
        // Arrange
        ISpacelineLaunchInfoProvider mock = new LaunchInfoProviderStub();

        // Act
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        List<LaunchInfo> launchList = sut.getLaunchList();


        //Assert
        int listSize = launchList.size();
        Assertions.assertEquals(2, listSize);
    }

    @Test
    public void Launches_Are_Sorted_Correctly_When_Destinations_Are_Unique() {
        //Arrange
        ISpacelineLaunchInfoProvider mock = new LaunchInfoProviderStub();

        //Act
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        List<LaunchInfo> launchList = sut.getLaunchList();

        //Assert
        String destination1 = launchList.get(0).getDestination();
        String destination2 = launchList.get(1).getDestination();
        Assertions.assertTrue(destination1.compareTo(destination2) > 0);
    }

    private class LaunchInfoProviderStub implements ISpacelineLaunchInfoProvider {

        @Override
        public List<LaunchInfo> getCurrentLaunches() {
            List<LaunchInfo> info = new ArrayList<>();
            var flight1 = new LaunchInfo(UUID.randomUUID());
            flight1.setDestination("A");
            var flight2 = new LaunchInfo(UUID.randomUUID());
            flight2.setDestination("B");
            info.add(flight1);
            info.add(flight2);
            return info;
        }
    }
}

package cs160.sjsu.edu.parkme.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Owner on 11/8/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    @Mock
    Order myOrder;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        myOrder = new Order(
                "1",
                "101",
                "201",
                "301",
                "11/05/17-18:59:49",
                "3",
                false);
    }

    @Test
    public void getOrderId() throws Exception {
        assertEquals(myOrder.getOrderId(), "1");
    }

    @Test
    public void setOrderId() throws Exception {
        myOrder.setOrderId("2");
        assertEquals(myOrder.getOrderId(), "2");
    }

    @Test
    public void getSellerId() throws Exception {
        assertEquals(myOrder.getSellerId(), "101");
    }

    @Test
    public void setSellerId() throws Exception {
        myOrder.setSellerId("102");
        assertEquals(myOrder.getSellerId(), "102");
    }

    @Test
    public void getBuyerId() throws Exception {
        assertEquals(myOrder.getBuyerId(), "201");
    }

    @Test
    public void setBuyerId() throws Exception {
        myOrder.setBuyerId("202");
        assertEquals(myOrder.getBuyerId(), "202");
    }

    @Test
    public void getParkingSpotId() throws Exception {
        assertEquals(myOrder.getParkingSpotId(), "301");
    }

    @Test
    public void setParkingSpotId() throws Exception {
        myOrder.setParkingSpotId("302");
        assertEquals(myOrder.getParkingSpotId(), "302");
    }

    @Test
    public void getStart_date() throws Exception {

    }

    @Test
    public void setStart_date() throws Exception {
        assertEquals(myOrder.getStart_date(), "11/05/17-18:59:49");
    }

    @Test
    public void getDurantion() throws Exception {
        assertEquals(myOrder.getDurantion(), "3");
    }

    @Test
    public void setDurantion() throws Exception {
        myOrder.setDurantion("4");
        assertEquals(myOrder.getDurantion(), "4");
    }

    @Test
    public void isPaid() throws Exception {
        assertEquals(myOrder.isPaid(), false);
    }

    @Test
    public void setPaid() throws Exception {
        myOrder.setPaid(true);
        assertEquals(myOrder.isPaid(), true);
    }

}
package org.zendesk.client.v2;

import org.junit.Test;
import org.zendesk.client.v2.model.AuditsWithSideload;
import org.zendesk.client.v2.model.Ticket;
import org.zendesk.client.v2.model.User;

import java.util.Date;

public class ZendeskSideloadTest {

    @Test
    public void testSideload() {
        Zendesk zd = new Zendesk.Builder("https://mrq.zendesk.com")
                .setUsername("steven@lindar.com")
                .setToken("7BevxXAOZGnrw4I0eVgAHFy10eFyPkLR1KkXJLwx")
                .build();

        Iterable<User> usersIncrementally = zd.getUsersIncrementally(new Date(0));

        for(User user : usersIncrementally){
        }

        Iterable<Ticket> ticketsIncrementally = zd.getTicketsIncrementally(new Date(0));

        Iterable<AuditsWithSideload> ticketAudits = zd.sideload()
                .withUsers()
                .withGroups()
                .withTickets()
                .getTicketAudits(138);

        for(AuditsWithSideload auditsWithSideload : ticketAudits) {
            System.out.println(auditsWithSideload.getCount());
        }

    }
}

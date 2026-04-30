package com.obedoza.app.obedoza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * What changed from previous lab?
 * Answer: There are more dependencies to be used and used real data from the user and the products created.
 *
 * Why database is better?
 * Answer: Data base is able to store more data, and is flexible because it can delete or change data more easily
 *
 * How JPA helped?
 * Answer: the switching of data bases is easier because changes aren't necessary.
 *
 * What changed when switching DB?
 * Answer: When switching to PostgreSQL the only file you need to touch is application.When switching to PostgreSQL,
 * the only file you need to touch is application.properties. Simply add # in front of all the H2 lines to disable them, and remove the # from the PostgreSQL lines to activate them.
 */

@SpringBootApplication
public class ObedozaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObedozaApplication.class, args);
    }

}

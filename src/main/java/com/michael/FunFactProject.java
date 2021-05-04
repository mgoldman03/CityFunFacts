
package com.michael;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class FunFactProject {
    static String newYorkInfo = " Tao. A fun sports team to watch is the New York Rangers.";
    static String miamiInfo = " Prime 112. A fun sports team to watch is the Miami Dolphins.";
    static String dallasInfo = " Gemma. A fun sports team to watch is the Dallas Stars.";
    static String losAngelosInfo = " Republique. A fun sports team to watch is the Los Angeles Kings.";
    static String philladelphiaInfo= " Alma del Mar. A fun sports team to watch is the Philadelphia Flyers.";
    static String bostonInfo = " Cafe Bonjour. A fun sports team to watch is the Boston Bruins.";
    static String wayneInfo = " Wayne Hills Diner. A fun sports team to watch is the WAYNE HILLS EFFIN PATRIOTS";
    static String fairLawnInfo = "Shaps House. A fun sports team to watch is the Fairlawn Cutters. AND THE STARTING GOALIE IS NATE THE GRATE!";
    static String montclairInfo = "Raymond's. A fun sports team to watch is the MKA Cougars hockey team carried by the MAN, the MYTH, the LEGEND: ARON DYADYUK!";
    static String ridgewoodInfo = "The Pancake House. A fun sports team to watch is...none...Ridgewood sucks at sports";
    static String missingInformation = "no information available for your city";


    public static void main(String[] args) {
        Spark.get("WhatsTheMove", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {

                return "<form action=\"/cityInformation\"> <input type=\"text\" name=\"city\"> <input type=\"submit\" value=\"Submit\"> </form>";
            }
        });
        Spark.get("cityInformation", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String requestedCity = request.queryParams("city");
                String information = missingInformation;
                if ("New York".equals(requestedCity)) {
                    information = newYorkInfo;
                } else {
                    if ("Miami".equals(requestedCity)) {
                        information = miamiInfo;
                    }
                }
                if ("Los Angelos".equals(requestedCity)) {
                    information = losAngelosInfo;
                } else {
                    if ("Philadelphia".equals(requestedCity)) {
                        information = philladelphiaInfo;
                    }
                }
                if ("Dallas".equals(requestedCity)) {
                    information = dallasInfo;
                } else {
                    if ("Boston".equals(requestedCity)) {
                        information = bostonInfo;
                    }
                }
                if ("Fairlawn".equals(requestedCity)) {
                    information = fairLawnInfo;
                } else if ("Wayne".equals(requestedCity)) {
                    information = wayneInfo;

                }
                if ("Ridgewood".equals(requestedCity)) {
                    information = ridgewoodInfo;
                } else if ("Montclair".equals(requestedCity)) {
                    information = montclairInfo;


                }

                return "<p>   In " + requestedCity + " you can go to a cool restaurant called " + information + "</p>";

            }
        });

    }
}



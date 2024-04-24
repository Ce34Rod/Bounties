//package org.CERN.bounties.models;
//
//import java.util.ArrayList;
//
//public class BountyData {
//
//    public static ArrayList<Bounty> findByColumnAndValue(String column, String value, Iterable<Bounty> allBounties) {
//
//        ArrayList<Bounty> results = new ArrayList<>();
//        if (value.toLowerCase().equals("all")) {
//            return (ArrayList<Bounty>) allBounties;
//        }
//        if (column.equals("all")) {
//            return results;
//        }
//        for (Bounty bounty : allBounties) {
//            String aValue = getFieldValue(bounty, column);
//            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
//                results.add(bounty);
//            }
//        }
//        return results;
//    }
//}

//    public static ArrayList
//}

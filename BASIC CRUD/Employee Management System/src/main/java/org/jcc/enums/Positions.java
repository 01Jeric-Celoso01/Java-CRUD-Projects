package org.jcc.enums;

import org.jcc.ui.UIDesign;

public class Positions {

    public static String[] getPositions(Departments department) {

        switch (department) {

            case Human_Resources:
                return new String[]{"HR Manager", "HR Officer", "HR Assistant", "Recruitment Officer", "HR Coordinator"};

            case Information_Technology:
                return new String[]{"IT Manager", "Software Developer", "Web Developer", "IT Support Specialist", "System Administrator"};

            case Finance:
                return new String[]{"Finance Manager", "Finance Officer", "Financial Analyst", "Treasurer", "Finance Assistant"};

            case Accounting:
                return new String[]{"Accounting Manager", "Accountant", "Accounting Assistant", "Bookkeeper", "Payroll Officer"};

            case Marketing:
                return new String[]{"Marketing Manager", "Marketing Officer", "Digital Marketing Specialist", "Graphic Designer", "Marketing Assistant"};

            case Sales:
                return new String[]{"Sales Manager", "Sales Supervisor", "Sales Representative", "Sales Associate", "Account Executive"};

            case Operations:
                return new String[]{"Operations Manager", "Operations Supervisor", "Operations Officer", "Operations Assistant"};

            case Administration:
                return new String[]{"Administrative Manager", "Administrative Officer", "Administrative Assistant", "Office Clerk", "Secretary"};

            case Customer_Service:
                return new String[]{"Customer Service Manager", "Customer Service Supervisor", "Customer Service Representative", "Customer Support Specialist"};

            case Engineering:
                return new String[]{"Engineering Manager", "Civil Engineer", "Electrical Engineer", "Mechanical Engineer", "Engineering Assistant"};

            case Production:
                return new String[]{"Production Manager", "Production Supervisor", "Production Operator", "Machine Operator"};

            case Quality_Assurance:
                return new String[]{"QA Manager", "QA Supervisor", "QA Engineer", "QA Tester", "Quality Inspector"};

            case Logistics:
                return new String[]{"Logistics Manager", "Logistics Officer", "Delivery Coordinator", "Logistics Assistant"};

            case Warehouse:
                return new String[]{"Warehouse Manager", "Warehouse Supervisor", "Warehouse Staff", "Inventory Clerk", "Stock Controller"};

            case Purchasing:
                return new String[]{"Purchasing Manager", "Procurement Officer", "Purchasing Assistant", "Buyer"};

            case Research_And_Development:
                return new String[]{"R&D Manager", "Research Analyst", "Research Assistant", "Product Developer"};

            case Legal:
                return new String[]{"Legal Manager", "Legal Officer", "Legal Assistant", "Compliance Officer"};

            case Security:
                return new String[]{"Security Manager", "Security Supervisor", "Security Guard"};

            case Public_Relations:
                return new String[]{"PR Manager", "PR Officer", "Communications Specialist", "Public Relations Assistant"};

            default:
                return new String[0];
        }
    }

    // DISPLAY DEPARTMENT AND AVAILABLE POSITIONS
    public static void displayPositions(Departments departments) {

        int totalSpace = 126;

        // DISPLAY DEPARTMENT
        String departmentName = departments.toString().replace("_", " ");

        System.out.print("|| ");
        System.out.printf("%-" + totalSpace + "s", departmentName);
        System.out.println(" ||");

        // GET AVAILABLE POSITIONS
        String[] positions = getPositions(departments);

        UIDesign.titleDesign("AVAILABLE POSITIONS");

        // DISPLAY POSITIONS
        int columnWidth = 42;
        int columns = 3;

        for (int i = 0; i < positions.length; i++) {

            if (i % columns == 0) {
                System.out.print("|| ");
            }

            System.out.printf("%-" + columnWidth + "s", (i + 1) + ") " + positions[i]);

            // END OF ROW
            if ((i + 1) % columns == 0 || i == positions.length - 1) {

                // Fill remaining columns on the last row
                int remainingColumns = columns - ((i + 1) % columns);

                if (remainingColumns != columns) {
                    System.out.printf("%" + (remainingColumns * columnWidth) + "s", "");
                }

                System.out.println(" ||");
            }
        }
    }
}
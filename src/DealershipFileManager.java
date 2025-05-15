import java.io.*;


class DealershipFileManager {
    Dealership getDealership() {
        File file = new File("dealership.csv");

        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Read the first line (dealership info)
            String firstLine = br.readLine();
            if (firstLine == null) {
                System.out.println("File is empty — no dealership info.");
                return null;
            }

            String[] data = firstLine.split("\\|");
            if (data.length < 3) {
                System.out.println("Dealership info is malformed.");
                return null;
            }

            String name = data[0];
            String address = data[1];
            String phone = data[2];

            Dealership dealership = new Dealership(name, address, phone);

            // Read vehicle lines
            String line;
            while ((line = br.readLine()) != null) {
                String[] vehicleData = line.split("\\|");

                if (vehicleData.length < 8) {
                    System.out.println("Skipping malformed vehicle line: " + line);
                    continue;
                }

                try {
                    int vin = Integer.parseInt(vehicleData[0]);
                    int year = Integer.parseInt(vehicleData[1]);
                    String make = vehicleData[2];
                    String model = vehicleData[3];
                    String vehicleType = vehicleData[4];
                    String color = vehicleData[5];
                    int odometer = Integer.parseInt(vehicleData[6]);
                    double price = Double.parseDouble(vehicleData[7]);

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(v);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping vehicle with invalid number format: " + line);
                }
            }

            return dealership;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    void saveDealership(Dealership dealership) {
        String path = System.getProperty("user.dir");
        File f = new File(path + "\\dealership.csv");
        FileWriter fw;
        try {
            fw = new FileWriter(f);
        } catch (Exception e) {
            System.out.println("Error reading file");
            return;
        }
        BufferedWriter bw = new BufferedWriter(fw);

        //write first line - dealer info
        String info = String.format("%s|%s|%s\n",
                dealership.getName(),
                dealership.getAddress(),
                dealership.getPhone()
        );
        try {
            bw.write(info);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //write line - per vehicle
        for (Vehicle v : dealership.getAllVehicles()) {
//            10112|1993|Ford|Explorer|SUV|Red|525123|995.00

            try {
                bw.write(String.format(
                        "%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        v.getVIN(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getType(),
                        v.getColor(),
                        v.getMiles(),
                        v.getPrice()
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        dfm.saveDealership(d);
    }
}

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalPoints = 0;
        for ( Point currenPt : s.getPoints()) {
         totalPoints= totalPoints + 1;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int totalPoints = getNumPoints(s);
        double avg =length/totalPoints;
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double biggest=0;
        Point prevPt = s.getLastPoint();
        for (Point pt : s.getPoints()){
            double currDist = prevPt.distance(pt);
            if(currDist > biggest) 
            {
                biggest = currDist;
            }
            prevPt = pt;
            
        }
        return biggest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double biggestX = prevPt.getX();
        for (Point pt : s.getPoints()){
            double currX = prevPt.getX();
            if(currX > biggestX) 
            {
                biggestX = currX;
            }
            prevPt =pt;
        }
        return biggestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource(); 
        double biggestLength =0;
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > biggestLength)
                biggestLength = length;
        }
        return biggestLength;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; 
        DirectoryResource dr = new DirectoryResource(); 
        double biggestLength =0;
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > biggestLength)
            {
                biggestLength = length;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int totalPoints = getNumPoints(s);
        double avg =getAverageLength(s);
        double biggestL = getLargestSide(s);
        double biggestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points:" + totalPoints);
        System.out.println("averagelentgh:" + avg);
        System.out.println("biggest side:" + biggestL);
        System.out.println("biggest X:" + biggestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("the largest lentgh is: " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("the file with the largest lentgh is: " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}

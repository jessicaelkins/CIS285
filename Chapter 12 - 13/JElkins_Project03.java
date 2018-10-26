/* In this project, I built a Java program that uses Java GUI components to
   display a window that calculates the price of a used car. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class JElkins_Project03 extends JFrame
{
   private statsPanel stats;
   private typePanel types;
   private titlePanel title;
   private JPanel buttonPanel;
   private JButton priceButton;

	public JElkins_Project03()
	{
		setTitle("Used Car Price");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		title = new titlePanel();
		types = new typePanel();
		stats = new statsPanel();

		buildButtonPanel();

		add(title, BorderLayout.NORTH);
		add(types, BorderLayout.WEST);
		add(stats, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	private void buildButtonPanel()
	{
		buttonPanel = new JPanel();

		priceButton = new JButton("Price");

		priceButton.addActionListener(new PriceButtonListener());

		buttonPanel.add(priceButton);
	}



 public class titlePanel extends JPanel
 {
    private JLabel title;

    public titlePanel()
    {
       title = new JLabel("TopCar Used Car Price Calculator");

       add(title);
    }
 }


// SELECT TYPE OF CAR

 public class typePanel extends JPanel
 {

   public final double COUPE = 14999.99;
   public final double SEDAN = 17999.99;
   public final double TRUCK = 21999.99;
   public final double SUV = 25999.99;
   public final double SPORTSCAR = 29999.99;


   private JRadioButton coupe;
   private JRadioButton sedan;
   private JRadioButton truck;
   private JRadioButton suv;
   private JRadioButton sportscar;
   private ButtonGroup carType;


   public typePanel()
   {
       // created a GridLayout with five rows and one column.
       setLayout(new GridLayout(5, 1));

       // created the radio buttons.
       coupe = new JRadioButton("Coupe");
       sedan = new JRadioButton("Sedan", true);
       truck = new JRadioButton("Truck");
       suv = new JRadioButton("SUV");
       sportscar = new JRadioButton("Sportscar");

       carType = new ButtonGroup();
       carType.add(coupe);
       carType.add(sedan);
       carType.add(truck);
       carType.add(suv);
       carType.add(sportscar);

       setBorder(BorderFactory.createTitledBorder("Type"));

       // adding the radio buttons to the panel.
       add(coupe);
       add(sedan);
       add(truck);
       add(suv);
       add(sportscar);
   }

   // return cost of the type of car selected

    public double getTypeCost()
    {
       double typeCost = 0.0;

       if (coupe.isSelected())
          typeCost = COUPE;
       else if (sedan.isSelected())
          typeCost = SEDAN;
       else if (truck.isSelected())
      	  typeCost = TRUCK;
       else if (suv.isSelected())
	 	  typeCost = SUV;
	   else
		  typeCost = SPORTSCAR;

       return typeCost;
    }
  }

// INPUT MODEL YEAR AND ODOMETER MILES

  public class statsPanel extends JPanel
  {

	 private JPanel modelYearPanel;
	 private JPanel odometerPanel;
	 private JLabel modelYearLabel;
	 private JTextField modelYearTextField;
	 private JLabel odometerLabel;
	 private JTextField odometerTextField;

	 public statsPanel()
	 {
		setLayout(new GridLayout(2, 1));

		modelYearLabel = new JLabel("Model Year");

		modelYearTextField = new JTextField(10);

		odometerLabel = new JLabel("Odometer");

		odometerTextField = new JTextField(10);

		modelYearPanel = new JPanel();
		odometerPanel = new JPanel();

		setBorder(BorderFactory.createTitledBorder("Stats"));

		modelYearPanel.add(modelYearLabel);
		modelYearPanel.add(modelYearTextField);
		odometerPanel.add(odometerLabel);
		odometerPanel.add(odometerTextField);
		add(modelYearPanel);
		add(odometerPanel);

	 }

	// return the cost of the stats

	public double getStatsCost()
	{
		double statsCost = 0.0, miles;
		int year;
		String input;

		input = modelYearTextField.getText();
		year = Integer.parseInt(input);

		input = odometerTextField.getText();
		miles = Integer.parseInt(input);

		year = 2018 - year;
		year = 500 * year;

		miles = miles * .10;

		statsCost = year + miles;

		return statsCost;
	}

}

  private class PriceButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
         double total;

         // calculate the total
         total = types.getTypeCost() - stats.getStatsCost();

         // created a DecimalFormat object to format output.
         DecimalFormat dollar = new DecimalFormat("#,##0.00");

         if (total < 500.00)
         	JOptionPane.showMessageDialog(null, "Vehicle Price: $" + dollar.format(500.00));
         else
         	JOptionPane.showMessageDialog(null, "Vehicle Price: $" + dollar.format(total));
      }
  }

 	public static void main(String[] args)
 	{
	 new JElkins_Project03();
 	}

}

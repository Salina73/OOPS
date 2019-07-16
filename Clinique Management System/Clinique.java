package clinique.bridgelab;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Clinique 
{
	static Date date;
	
	public static void main(String[] args) 
	{ 
		Scanner s=new Scanner(System.in);
		Utility u=new Utility();
		Find f=new Find();
		HashMap<Appointment,Integer> appoint=new HashMap<Appointment,Integer>();
		Patients p=new Patients();
		Doctor d=new Doctor();
		ArrayList<Doctor> ald = new ArrayList<Doctor>();
		ArrayList<Patients> alp = new ArrayList<Patients>();
		char c3;
		do
		{
		System.out.println();
		System.out.println("<-------Welcome to the bridgelab's clinique------->");
		System.out.println();
		System.out.println("1.Add Doctor");
		System.out.println("2.Add Patients");
		System.out.println("3.Print Doctor");
		System.out.println("4.Print Patients");
		System.out.println("5.Take Appointment");
		System.out.println("6.Print Appointment");
		System.out.println("7.Search Doctor by Name ,Id or Availability");
		System.out.println("8.Search Patient by Name ,Id or Mobile Number");
		System.out.println("9.Exit");
		System.out.println();
		System.out.println("Enter your Choice: ");
		int choice=u.inputInteger();
		switch (choice) 
		{
			case 1:
					d.addDoctor();
					ald.add(d);
					break;
			case 2:
					p.addPatient();
					alp.add(p);
					break;
			case 3:
					
					System.out.println("All Doctors Details..");
					System.out.println(ald);
					break;
			case 4:
					
					System.out.println("All Patient Details..");
					System.out.println(alp);
					break;
			case 5:
					System.out.println("Enter Doctor Id ");
					int did=u.inputInteger();
					ArrayList<Doctor>doc=f.FindById(ald, did);
					if(doc!=null)
					{
						if(doc.size()>=1)
						{
							System.out.println("Enter Date of Appointment(eg.10/06/2016): ");
							Date date=u.printDate(u.inputString());
							if(date==null)
							{
								System.out.println("Date format is not correct");
							}
							
							else
							{
								Appointment newApp=new Appointment(did, date);
								if(appoint.containsKey(newApp))
								{
									
									Integer appointment=appoint.get(newApp);
									if(appointment<=5)
									{
										
										appointment++;
										appoint.put(newApp,appointment);
										System.out.println("Appointment Scheduled on "+date.toString()+" "+" with Doctor Id"+did);
									}
									else
									{
										
										System.out.println("Please Select Another Date"); 
									}
								}
								else
								{
									
									appoint.put(newApp,1);
								}
							}
						}
						
						else
						{
							System.out.println("Invalid Doctor Id");
						}
					}
					else
					{
						System.out.println("Invalid Doctor Id");
					}
					break;
			case 6:
					System.out.println("Printing All Appointments...");
					appoint.putAll(appoint);
					System.out.println(appoint);
					break;
			case 7:
				char c1;
					do
					{
						
						System.out.println();
						System.out.println("<-------Search Doctor------->");
						System.out.println();
						System.out.println("1.Search Doctor By id");
						System.out.println("2.Search Doctor By Name");
						System.out.println("3.Search Doctor By Availability");
						System.out.println("4.Exit");
						System.out.println();
						System.out.println("Enter your Choice: ");
						int ch=u.inputInteger();

						switch (ch) 
						{
						case 1:
								System.out.println("1.Enter Doctor Id");
								int did1=u.inputInteger();
								ald=f.FindById(ald,did1);
								
								System.out.println(ald);
								break;
						case 2:
								System.out.println("Enter Doctor Name");
								String dname=u.inputString();
								ald=f.FindByName(ald,dname);
								System.out.println(ald);			
								break;
						case 3:
								
								System.out.println("Enter Doctor Availability");
								String avail=u.inputString();
								ald=f.FindByava(ald,avail);
								System.out.println(ald);
								break;
						case 4:
								System.exit(0);
						default:
								System.out.println("Invalid choice");
						}
								System.out.println("Do you want to perform more operations?");
								c1=s.next().charAt(0);					
					}while(c1=='y'|| c1=='Y');
					break;
		
			case 8:
					Find f1=new Find();
				
					char c2;
					do
					{
						System.out.println();
						System.out.println("<-------Search Patients------->");
						System.out.println();
						System.out.println("1.Search Patient by Id");
						System.out.println("2.Search Patient by Name");
						System.out.println("3.Search Patient by Mobile Number");
						System.out.println("4.Exit");
						System.out.println();
						System.out.println("Enter your Choice: ");
						int ch3=u.inputInteger();
						switch (ch3) 
						{
						case 1:
								
								System.out.println("Enter Patients  Id");
								int pid1=u.inputInteger();
								alp=f1.FindById1(alp,pid1);
								System.out.println(alp);
								break;
						case 2:
								
								System.out.println("Enter Patients Name");
								String pname1=u.inputString();
								alp=f1.FindByName1(alp,pname1);
								System.out.println(alp);
								break;
						case 3:
							
								System.out.println("Enter Patients Mobile Number");
								String avail1=u.inputString();
								alp=f1.FindByava1(alp,avail1);
								System.out.println(alp);
								break;
						case 4:
								System.exit(0);
						default:
								System.out.println("Invalid choice");
						}
						System.out.println("Do you want to perform more operations?");
						c2=s.next().charAt(0);					
			}while(c2=='y'|| c2=='Y');
			break;
			case 9:
					System.exit(0);
					break;
			default:
					System.out.println("Invalid choice");
					System.out.println("Invalid choice");
		}
		System.out.println("Do you want to perform main operations?");
		c3=s.next().charAt(0);					
}while(c3=='y'|| c3=='Y');
	}
}

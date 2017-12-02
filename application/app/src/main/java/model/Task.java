package model;

import java.util.Date;

public class Task {
    private int id;
    private int points;
    private boolean available;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Date dueDate;
    private User creator;
    private User assignedUser;
    //Ressource List
    //GroupTache

    //Default
    public Task() {}
    //Minimum Constructor
    public Task (int points, String name, String description, Date dueDate, User creator) {
        this.points = points;
        this.available = false;
        this.name = name;
        this.description = description;
        this.startDate = null;
        this.endDate = null;
        this.dueDate = dueDate;
        this.creator = creator;
    }
    //With start/end Date
    public Task (int points, String name, String description, Date startDate, Date endDate, Date dueDate, User creator) {
        this.points = points;
        this.available = false;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dueDate = dueDate;
        this.creator = creator;
    }
    //Assign
    public Task (int points, boolean available, String name, String description, Date dueDate, User creator) {
        this.points = points;
        this.available = available;
        this.name = name;
        this.description = description;
        this.startDate = null;
        this.endDate = null;
        this.dueDate = dueDate;
        this.creator = creator;
    }
    //With start/end Date & assign
    public Task (int points, boolean available, String name, String description, Date startDate, Date endDate, Date dueDate, User creator) {
        this.points = points;
        this.available = available;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dueDate = dueDate;
        this.creator = creator;
    }

    //getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPoints(){
        return this.points;
    }
    public void setPoints(int points){
        this.points = points;
    }

    public boolean isAvailable(){
        return this.available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.name = description;
    }

    public Date getStartDate(){
        if(startDate != null){
            return (Date) this.startDate.clone();
        }
        return null;
    }
    public void setStartDate(Date startDate){
        if(startDate != null){
            this.startDate = (Date) startDate.clone();
        }
    }

    public Date getEndDate(){
        if(startDate != null){
            return (Date) this.endDate.clone();
        }
        return null;
    }
    public void setEndDate(Date endDate){
        if(startDate != null){
            this.endDate = (Date) endDate.clone();
        }
    }

    public Date getDueDate(){
        if(startDate != null){
            return (Date) this.dueDate.clone();
        }
        return null;
    }
    public void setDueDate(Date dueDate){
        if(startDate != null){
            this.dueDate = (Date) dueDate.clone();
        }
    }

    public User getCreator(){
        return this.creator;
    }
    public void setCreator(User creator){
        this.creator = creator;
    }

    public User getAssignedUser(){
        return this.assignedUser;
    }
    public void setAssignedUser(User assignedUser){
        this.assignedUser = assignedUser;
    }

    public long getDateLong(Date date) {
        return date.getTime();
    }
    public Date getDate(long date) {
        return new Date(date);
    }
}

/*
Calendar cal = Calendar.getInstance();
cal.set(Calendar.YEAR, 1988);
cal.set(Calendar.MONTH, Calendar.JANUARY);
cal.set(Calendar.DAY_OF_MONTH, 1);
cal.getTimeInMillis()


Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(timeStamp);

System.out.println(cal.getTimeInMillis());

Calendar calendar = Calendar.getInstance();
//calendar.setTimeInMillis(timeStamp);

System.out.println(calendar.get(mYear));
System.out.println(calendar.get(mMonth));
System.out.println(calendar.get(mDay));
 */
package toDoactivities;

public class ToDoList 
{
		int id;
		String activity;
		String description;
		String date;
		String Status;
		
		public ToDoList(int id, String activity, String description, String date, String status) 
		{
			super();
			this.id = id;
			this.activity = activity;
			this.description = description;
			this.date = date;
			this.Status = status;
		}
		public ToDoList(String activity, String description, String date, String status) 
		{
			super();
			this.activity = activity;
			this.description = description;
			this.date = date;
			this.Status = status;
		}
		public int getId() 
		{
			return id;
		}		
		public void setId(int id) 
		{
			this.id = id;
		}
		public String getActivity() 
		{
			return activity;
		}
		public void setActivity(String activity)
		{
			this.activity = activity;
		}
		public String getDescription() 
		{
			return description;
		}
		public void setDescription(String description)
		{
			this.description = description;
		}
		public String getDate() 
		{
			return date;
		}
		public void setDate(String date)
		{
			this.date = date;
		}
		public String getStatus()
		{
			return Status;
		}
		public void setStatus(String status)
		{
			Status = status;
		}	
	}

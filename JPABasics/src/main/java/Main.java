import com.wileyedge.dao.EmployeeDAO;
import com.wileyedge.dao.IDao;

public class Main {

	public static void main(String[] args) {
		IDao dao=new EmployeeDAO();
		dao.createEmployee(100, "Sanskar", "Jaiswal");
		dao.createEmployee(101, "Vimal", "Jaiswal");
		dao.updateEmployee(100, "Christopher");
		dao.removeEmployee(101);
	}

}

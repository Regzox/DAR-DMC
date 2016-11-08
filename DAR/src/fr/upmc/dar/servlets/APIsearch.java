package fr.upmc.dar.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.api.client.json.JsonObjectParser;
import com.google.gson.Gson;

import fr.upmc.dar.api.helpers.YelpBusinessSearch;
import fr.upmc.dar.entities.Business;

/**
 * Servlet implementation class APIsearch
 */
@WebServlet("/APIsearch")
public class APIsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIsearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lieu = request.getParameter("lieu");
		System.out.println("Recherche de : "+lieu);
		String ville = request.getParameter("ville");
		System.out.println("Recherche dans la ville de  : "+ville);
		JSONObject res=new JSONObject();
		try {
			List<String> businessIds=YelpBusinessSearch.searchBuisnessIds(lieu,ville, 5);
			List<Business> bs=YelpBusinessSearch.idsToBusiness(businessIds);

			Gson gson = new Gson();
			JSONArray array=new JSONArray();
			String directRes="";
			
			String htmltab = "<table class=\"table table-hover\">"+
           "<thead><tr><th>Etablissement </th><th>Horaire D'ouverture</th><th>Adresse</th><th>ville</th><th>Code Postal</th><th>Action</th>"+
            "</tr></thead><tbody>";
       
			directRes+=htmltab;
			for(Business b : bs){
				if(b!=null){
					JSONObject json=new JSONObject(gson.toJson(b));
					array.put(json);

					
					String h="<ul><li>Lundi :<br /> "+b.normalizeHour(b.getOp0())+"-"+b.normalizeHour(b.getCl0())+"</li>";
					h+="<li>Mardi :<br /> "+b.normalizeHour(b.getOp1())+"-"+b.normalizeHour(b.getCl1())+"</li>";
					h+="<li>Mercredi :<br /> "+b.normalizeHour(b.getOp2())+"-"+b.normalizeHour(b.getCl2())+"</li>";
					h+="<li>Jeudi :<br /> "+b.normalizeHour(b.getOp3())+"-"+b.normalizeHour(b.getCl3())+"</li>";
					h+="<li>Vendredi :<br /> "+b.normalizeHour(b.getOp4())+"-"+b.normalizeHour(b.getCl4())+"</li>";
					h+="<li>Samedi :<br /> "+b.normalizeHour(b.getOp5())+"-"+b.normalizeHour(b.getCl5())+"</li>";
					h+="<li>Dimanche :<br /> "+b.normalizeHour(b.getOp6())+"-"+b.normalizeHour(b.getCl6())+"</li></ul>";
					
					HashMap<String,String> horaires = new HashMap<String,String>();
					horaires.put("Lu", b.normalizeHour(b.getOp0())+"-"+b.normalizeHour(b.getCl0()));
					horaires.put("Ma",b.normalizeHour(b.getOp1())+"-"+b.normalizeHour(b.getCl1()));
					horaires.put("Me",b.normalizeHour(b.getOp2())+"-"+b.normalizeHour(b.getCl2()));
					horaires.put("Je",b.normalizeHour(b.getOp3())+"-"+b.normalizeHour(b.getCl3()));
					horaires.put("Ve",b.normalizeHour(b.getOp4())+"-"+b.normalizeHour(b.getCl4()));
					horaires.put("Sa",b.normalizeHour(b.getOp5())+"-"+b.normalizeHour(b.getCl5()));
					horaires.put("Di",b.normalizeHour(b.getOp6())+"-"+b.normalizeHour(b.getCl6()));
					List<String> days= new ArrayList<String>();
					for(String hh:horaires.keySet()){
						if(horaires.get(hh).equals(b.normalizeHour(b.getOp0())+"-"+b.normalizeHour(b.getCl0()))){
							days.add(hh);
						}
					}
					
					if(days.size()==7){
						h="";
						h="7j/7<br/>"+b.normalizeHour(b.getOp0())+"-"+b.normalizeHour(b.getCl0());
					}
					directRes+="<tr><td>"+b.getName()+"</td><td>"+h +"</td><td>"+b.getStreet()+"</td><td>"+b.getCity()+"</td><td>"+b.getZipCode()+"</td><td><a href=\"\" class=\"btn btn-primary\">Choisir</a> </td></tr>";
//					directRes+="<div class=\"media-body\">"+
//							"<h4 class=\"media-heading\"> "+b.getName()+"</h4>"+
//							"<p class=\"text-right\"><b>Adresse </b>:" + b.getStreet() +"</p>"+
//							"<p> <b>Code Postale</b>: " + b.getZipCode() +" </p>"+
//							"<p> <b>Horaires </b>:"  +h + "</p>"+
//							"<a href=\""+b.getEstablishmentWebsite()+" target=\"_blank\"> Voir </a>"+
//							"<p class=\"text-right\"><a href=\"\" class=\"btn btn-primary\">Choisir</a> </p>"+
//							"</div>";
				}
			}
			
			directRes+="</tbody> </table> ";
			System.out.println("Envoie : "+array.length() +" | "+directRes.length());

			res.put("result", array);
			res.put("html", directRes);
			
			response.getWriter().println(res);

		} catch (JSONException e) {
			try {
				res.put("error", "Aucun R�sultat");
				response.getWriter().println(res);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
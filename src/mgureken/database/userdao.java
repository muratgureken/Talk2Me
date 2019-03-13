/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgureken.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mgureken
 */
public class userdao extends registerInfos{
    	private static String url="jdbc:postgresql://127.0.0.1:5432/KullaniciYonetimi";
	private static String username="postgres";
	private static String password="sifre123";
	private Connection conn;

    public userdao() throws SQLException{
        try {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url, username, password); //try/catch'e gerek yok, metot throwable yapildi.
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

        conn.close();
    }
    
    public void bringAllRegisters()
    {
        //registerInfos'daki linkedlist'leri doldur
    }
    
    public void updateRegister(int id, int socket, boolean connState)
    {
        //hem database hem deregisterInfos'daki linkedlist'leri update et.
        int index = getIdList().indexOf(id);
        getSocketList().set(index, socket);
        getConnStateList().set(index, connState);
        
        //database'e yaz.
    }
    
    public void makeAllRegistersPassive()
    {
        int size = getIdList().size();
        
        for(int i=0; i<size; i++)
        {
            getConnStateList().set(i, false);
            //database'e yaz.
        }
    }
}

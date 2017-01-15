/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;



/**
 *
 * @author S153298
 */
public class Advertisement 
{
    private String filePath;
    private String time;
    private String url;
    private String balance; 
    
    public Advertisement(String filePath, String time, String url)
    {
        this.filePath = filePath;
        this.time = time;
        this.url = url;
    }
    public String getFilePath()
    {
        return(filePath);
    }
    public String getTime()
    {
        return(time);
    }
    public String getUrl()
    {
        return(url);
    }
    public String getBalance(){
        return (balance);
    }
}

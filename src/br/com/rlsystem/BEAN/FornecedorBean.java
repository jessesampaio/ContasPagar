package br.com.rlsystem.BEAN;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.rlsystem.DAO.Fornecedor;
import br.com.rlsystem.DAO.FornecedorDAO;

@ManagedBean(name="forBean")
@SessionScoped
public class FornecedorBean {
	
	private Fornecedor fornecedor = new Fornecedor();
	private DataModel<Fornecedor> fornecedores;
	
	public String addFornecedor() {
		
		String retorno = "erro";
		
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.Salvar(fornecedor);
			retorno = "listar";
		}catch(Exception ex){
			System.out.println("ERRO: " + ex.getMessage());
		}
		return retorno;		
	}
	
	public String deleteFornecedor() {
		
		String retorno = "erro";
		
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.Delete(fornecedor);
			retorno = "listar";
		}catch(Exception ex){
			System.out.println("ERRO: " + ex.getMessage()); //Apenas para uso no Debug
		}
		return retorno;		
	}
	public String updateFornecedor() {
		
		String retorno = "erro";
		
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.Update(fornecedor);
			retorno = "listar";
		}catch(Exception ex){
			System.out.println("ERRO: " + ex.getMessage());
		}
		return retorno;		
	}
	
	public void selecionarForecedor(){
		this.fornecedor = fornecedores.getRowData();
	}
	
	public void novoFornecedor(){
		fornecedor = new Fornecedor();
	}

	//Getters and Setters
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public DataModel<Fornecedor> getFornecedores(){
		FornecedorDAO dao = new FornecedorDAO();
		
		try {
			//Retorna lista de fornecedores
			List<Fornecedor> lista = dao.GetALL(); 
			fornecedores = new ListDataModel<Fornecedor>(lista);
		} catch (Exception e) {			
		}
		
		return fornecedores;		
	}

	public void setFornecedores(DataModel<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
package br.com.rlsystem.BEAN;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.rlsystem.DAO.Fornecedor;
import br.com.rlsystem.DAO.FornecedorDAO;

@ManagedBean(name="forBean")
@SessionScoped
public class FornecedorBean {
	
	private Fornecedor fornecedor = new Fornecedor();
	
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

	//Getters and Setters
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
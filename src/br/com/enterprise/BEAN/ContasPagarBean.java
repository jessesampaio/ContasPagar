package br.com.enterprise.BEAN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.enterprise.DAO.ContasPagar;
import br.com.enterprise.DAO.ContasPagarDAO;
import br.com.enterprise.DAO.Fornecedor;
import br.com.enterprise.DAO.FornecedorDAO;

@ManagedBean(name = "cpBean")
@SessionScoped
public class ContasPagarBean {

	private ContasPagar contasPagar = new ContasPagar();
	private DataModel<ContasPagar> contasPagarFull;
	private int fornecedor_id;
	
	
	//Lista de Métodos
	
	public String addContasPagar() {
		String retorno = "erro";

		try {
			ContasPagarDAO dao = new ContasPagarDAO();
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			contasPagar.setFornecedor(fornecedorDao.Get(fornecedor_id));
			dao.Salvar(contasPagar);
			retorno = "listar";
		} catch (Exception ex) {
			System.out.println("ERRO: " + ex.getMessage());
		}
		return retorno;
	}

	public void selecionarContasPagar() {
		this.contasPagar = contasPagarFull.getRowData();
	}

	public void novoContasPagar() {
		contasPagar = new ContasPagar();
	}

	public DataModel<ContasPagar> getContasPagarFull() {
		ContasPagarDAO dao = new ContasPagarDAO();

		try {
			// Retorna lista de fornecedores
			List<ContasPagar> lista = dao.GetALL();
			contasPagarFull = new ListDataModel<ContasPagar>(lista);
		} catch (Exception e) {

		}

		return contasPagarFull;
	}

	public Collection<SelectItem> getCarregarFornecedores(){
		
		FornecedorDAO dao = new FornecedorDAO();
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("-- SELECIONE --"));
		
		List<Fornecedor> listaFornecedor = dao.GetALL(); 
		for (int i = 0; i < listaFornecedor.size(); i++) {
			lista.add(new SelectItem(listaFornecedor.get(i).getId(), listaFornecedor.get(i).getNome()));			
		}
		
		return lista;
	}
	
	// Getters and Setters
	public ContasPagar getContasPagar() {
		return contasPagar;
	}
	public void setContasPagar(ContasPagar contasPagar) {
		this.contasPagar = contasPagar;
	}
	public void setContasPagarFull(DataModel<ContasPagar> contasPagarFull) {
		this.contasPagarFull = contasPagarFull;
	}
	public int getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}

}
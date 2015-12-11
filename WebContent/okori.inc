<li class="dropdown">
          <meta charset="UTF-8">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="glyphicon glyphicon-shopping-cart"></span>Ostoskori<span class="caret"></span></a>
          <ul class="dropdown-menu dropdown-cart" role="menu">
            
              <% Iterator it2 = ostoskoritaulukko.iterator();
              	 while (it2.hasNext()) {  %>
		              <li>
		                  <span class="item">
		                    <span class="item-left">
		                        
		                        <span class="item-info">
		                            <span>
		                           		 <% 
											
											OstoskoriPizza ostoskoriItem = (OstoskoriPizza) it2.next(); %>
											<%=ostoskoriItem.getTuote_id() %>.
											<%=ostoskoriItem.getTuote_nimi() %>
											<%=ostoskoriItem.getRivihinta() %> &euro;
		                            </span>
		                            
		                        </span>
		                    </span>
		                    
		                </span>
		              </li>
              <% } %>
              
              
              
              
              <li class="divider"></li>
              <li><a class="text-center" href="Tilaus">Tee tilaus</a></li>
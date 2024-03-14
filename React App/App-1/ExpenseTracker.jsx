import Header from './Header/Header';
import Balance from './Balance/Balance';
import Track from './Balance/Track';

function ExpenseTracker(){
   return(
   <>
   <Header/>
   <div className="main-container">
      <div className="div-container">
         <div className="container">
           <div className='budget-the-container'>
              <Balance/>
              <Track/>
           </div>
         </div>
      </div>
   </div>
   </>
   )
}

export default ExpenseTracker;
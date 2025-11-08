
export default function Track(){
    return(
      <>
        <div className="track-wrapper">
          <div className="track-main-container">
                <div className="track-container track-container-1">
                  <p className="track-text">Income</p>
                  <p className="track-amount income">$1000.00</p>
                </div>
                <div className="track-container track-container-2">
                  <p className="track-text">Expense</p>
                  <p className="track-amount expense">$500.00</p>
                </div>
          </div>
        </div>
      </>
    )
}
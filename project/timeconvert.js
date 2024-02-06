import React from 'react';
import { useState } from "react";

export default function Clock() {
    const [time, setTime] = useState({hours: 0, mins: 0, seconds: 0});
    const convertTime = (time, value) => {
      switch (time) {
        case 'hours':
          setTime({hours: value, mins: value * 60, seconds: value * 3600});
          break;
        case 'mins':
          setTime({hours: value / 60, mins: value, seconds: value * 60});
          break;
        case 'seconds':
          setTime({hours: value / 3600, mins: value / 60, seconds: value});
          break;
      }
    }


    return (
      <div>
        <div className={'header'}>
          <h1>Time Convert</h1>
        </div>

        <div className={'mainContent'}>
            <div className={'unit'}>
              <label>Hours:</label>
              <input id={'hours'} value={time.hours} onChange={(e) => convertTime('hours', e.target.value)} ></input>
            </div>

            <div className={'unit'}>
              <label>Mins:</label>
              <input id={'mins'} value={time.mins} onChange={(e) => convertTime('mins', e.target.value)}></input>
            </div>

            <div className={'unit'}>
              <label>Seconds:</label>
              <input id={'seconds'} value={time.seconds} onChange={(e) => convertTime('seconds', e.target.value)}></input>
            </div>
        </div>
      </div>
        );


}
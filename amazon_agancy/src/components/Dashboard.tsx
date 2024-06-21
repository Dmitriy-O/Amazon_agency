import React, {useEffect, useState} from "react";
import {
    Tooltip,
    BarChart,
    XAxis,
    YAxis,
    Legend,
    CartesianGrid,
    Bar,
} from "recharts";

type ADdata = {
    name: string,
    performance: number
}
const App: React.FC = () => {
    const [data, setData] = useState<ADdata[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/ads', {
            method: 'GET'
        }).then(response => response.json())
            .then(data => {
                const parsedData: ADdata[] = data.map((item: any) => ({
                    name: item.name,
                    performance: item.performance,
                }));
                parsedData.sort((a, b) => a.performance - b.performance);
                setData(parsedData);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div style={{textAlign: "center"}}>
            <h1>Social Media Users</h1>
            <div className="App">
                <BarChart
                    width={700}
                    height={300}
                    data={data}
                   margin={{
                       top: 10,
                       right: 10,
                       bottom: 20,
                       left: 40,
                   }}
                    barSize={20}
                >
                    <XAxis
                        dataKey="name"
                    />
                    <YAxis/>
                    <Tooltip/>
                    <Legend/>
                    <CartesianGrid strokeDasharray="3"/>
                    <Bar
                        dataKey="performance"
                        fill="purple"
                    />
                </BarChart>
            </div>
        </div>
    );
};

export default App;

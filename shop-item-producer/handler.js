const AWS = require('aws-sdk');
const sqs = new AWS.SQS();
const queueUrl = process.env.QUEUE_URL;

const items = [{
    name: "Cheese",
    price: 1.99,
}, {
    name: "Bread",
    price: 2.99,
}, {
    name: "Milk",
    price: 0.99,
}, {
    name: "Water",
    price: 0.49,
}, {
    name: "Coke",
    price: 50.00,
}, {
    name: "Beer",
    price: 1.99,
}, {
    name: "Wine",
    price: 10.00,
}, {
    name: "Chocolate",
    price: 1.00,
}, {
    name: "Chips",
    price: 1.00,
}, {
    name: "Sweets",
    price: 1.00,
}, {
    name: "Biscuits",
    price: 1.00,
}, {
    name: "Crisps",
    price: 1.00,
}, {
    name: "Cereal",
    price: 1.00,
}, {
    name: "Pasta",
    price: 1.00,
}, {
    name: "Rice",
    price: 1.00,
}, {
    name: "Noodles",
    price: 1.00,
}, {
    name: "Pizza",
    price: 1.00,
}]

exports.handler = async (event) => {
    const checkoutEvent = {
        timestamp: new Date().toISOString(),
        items: items
            .map(a => [a, Math.random()])
            .sort((a, b) => {
                return a[1] < b[1] ? -1 : 1;
            })
            .slice(0, Math.floor(Math.random() * (8 - 3 + 1) + 3))
            .map(a => a[0]),
    };
    const params = {
        MessageBody: JSON.stringify(checkoutEvent),
        QueueUrl: queueUrl,
    };
    console.log(`Checked out [${checkoutEvent.items.map(item => item.name)}] at ${checkoutEvent.timestamp}`)
    await sqs.sendMessage(params).promise();
};
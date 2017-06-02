const webpack = require('webpack');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	entry: {
		main: './src/index.tsx',
		vendor: ['react', 'react-dom', 'jquery', 'bootstrap']
	},
	output: {
		filename: '[name].[chunkhash].js',
		path: path.resolve(__dirname, 'dist')
	},
	module: {
		rules: [
			{
				test: /\.html$/,
				use: 'html-loader'
			}, {
				test: /\.css$/,
				use: ExtractTextPlugin.extract({
					fallback: "style-loader",
					use: "css-loader"
				})
			}, {
				test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000'
			}, { 
				test: /\.tsx?$/, 
				loader: "awesome-typescript-loader" 
			}, { 
				enforce: "pre", test: /\.js$/, 
				loader: "source-map-loader" 
			}
		]
	},
	plugins: [new HtmlWebpackPlugin({
		template: "./src/index.html"
	}),
	new ExtractTextPlugin("styles.css"),
	new webpack.ProvidePlugin({
		$: 'jquery',
		jQuery: 'jquery'
	}),
	new webpack.optimize.CommonsChunkPlugin({
		name: 'vendor' // Specify the common bundle's name.
	})
	],
	devServer: {
		contentBase: path.join(__dirname, "dist"),
		compress: true,
		port: 9000,
		inline: true
	},
	devtool: 'source-map',
	externals: {
		'Config': JSON.stringify(process.env.ENV === 'production' ? {
			serverUrl: "http://localhost:8080/"
		} : {
				serverUrl: "http://localhost:3000/"
			})
	}
};
